package com.example.camerax

import android.app.Activity
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Size
import android.view.ViewGroup
import androidx.camera.core.AspectRatio
import androidx.camera.core.CameraX
import androidx.camera.core.Preview
import androidx.camera.core.impl.PreviewConfig
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED){
            //start work for Camera
            textureView.post {
                startCamera()
            }

        }else{
            ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.CAMERA), 123)
        }
    }

    private fun startCamera() {
        val preview = Preview.Builder()
                .setTargetResolution(Size(640, 480))
                .setTargetAspectRatio(AspectRatio.RATIO_16_9)
                .build()
        preview.setOnPreviewOutputUpdatelistener {
            val parent = textureView.parent as ViewGroup
            parent.removeView(textureView)
            parent.addView(textureView,0)
            textureView.surfaceTexture = it.surfaceTexture
        }

        CameraX.bindToLifecycle(this,preview)
    }
}