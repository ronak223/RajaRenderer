package edu.wm.cs.rajarenderer;

import javax.microedition.khronos.opengles.GL10;

import rajawali.Object3D;
import rajawali.lights.DirectionalLight;
import rajawali.materials.Material;
import rajawali.materials.textures.ATexture.TextureException;
import rajawali.materials.textures.Texture;
import rajawali.parser.LoaderOBJ;
import rajawali.parser.ParsingException;
import rajawali.renderer.RajawaliRenderer;
import android.content.Context;
import android.graphics.Camera;

public class MainRenderer extends RajawaliRenderer {
	
	public DirectionalLight mLight;
    public Object3D mSphere;
    public Context context;
    public Camera camera;
    public Object3D mObj;

	public MainRenderer(Context context) {
		super(context);
		setFrameRate(60);
	}
	
	public void initScene() {
		mLight = new DirectionalLight(1f, 0.2f, -1.0f); // set the direction
		mLight.setColor(1.0f, 1.0f, 1.0f);
		mLight.setPower(2);
		
		try {
			/*Material material = new Material();
			material.addTexture(new Texture("hammer_d", R.drawable.hammer_d));
            material.setColorInfluence(0);
            mSphere = new Sphere(1, 24, 24);
            mSphere.setMaterial(material);
            getCurrentScene().addLight(mLight);
            super.addChild(mSphere);
            */
			LoaderOBJ parser = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.hammer_obj);
			parser.parse();
			mObj = parser.getParsedObject();
			//addChild(mObj); 
			
			
			Material material = new Material();
			material.addTexture(new Texture("hammer_d", R.drawable.hammer_d));
			
			mObj.setMaterial(material);
			getCurrentScene().addLight(mLight);
			addChild(mObj);
			
			
		} catch (ParsingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TextureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getCurrentCamera().setZ(4.2f);
		
	}
	
	@Override
    public void onDrawFrame(GL10 glUnused) {
        super.onDrawFrame(glUnused);
        //mSphere.setRotY(mSphere.getRotY() + 1);
        mObj.setRotX(mObj.getRotX() + 1);
       
        
    }
    
	
	

}
