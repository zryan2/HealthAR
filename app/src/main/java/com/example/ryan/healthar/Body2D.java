package com.example.ryan.healthar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */


public class Body2D extends Fragment implements View.OnClickListener {

    TextView partInfo;

    Fragment infoFragment = null;
    FragmentTransaction fm;

    ImageButton leftAnkleFront;
    ImageButton leftArmFront;
    ImageButton leftLegBottomFront;
    ImageButton leftLegTopFront;
    ImageButton leftFootFront;
    ImageButton rightAnkleFront;
    ImageButton rightArmFront;
    ImageButton rightLegBottomFront;
    ImageButton rightLegTopFront;
    ImageButton rightFootFront;
    ImageButton sideFront;
    ImageButton neckFront;
    ImageButton headFront;
    ImageButton crotch;
    ImageButton chest;
    ImageButton abs;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2d_body, container, false);
        partInfo = (TextView) v.findViewById(R.id.partInfo);
        leftAnkleFront = (ImageButton) v.findViewById(R.id.left_ankle_front_btn);
        leftArmFront= (ImageButton) v.findViewById(R.id.left_arm_front_btn);
        leftLegBottomFront= (ImageButton) v.findViewById(R.id.left_leg_bottom_front_btn);
        leftLegTopFront= (ImageButton) v.findViewById(R.id.left_leg_top_front_btn);
        leftFootFront = (ImageButton) v.findViewById(R.id.left_foot_front_btn);
        rightAnkleFront = (ImageButton) v.findViewById(R.id.right_ankle_front_btn);
        rightArmFront = (ImageButton) v.findViewById(R.id.right_arm_front_btn);
        rightLegBottomFront = (ImageButton) v.findViewById(R.id.right_leg_bottom_front_btn);
        rightLegTopFront = (ImageButton) v.findViewById(R.id.right_leg_top_front_btn);
        rightFootFront = (ImageButton) v.findViewById(R.id.right_foot_front_btn);
        sideFront = (ImageButton) v.findViewById(R.id.sides_front_btn);
        neckFront = (ImageButton) v.findViewById(R.id.neck_front_btn);
        headFront = (ImageButton) v.findViewById(R.id.head_front_btn);
        crotch = (ImageButton) v.findViewById(R.id.crotch_btn);
        chest = (ImageButton) v.findViewById(R.id.chest_btn);
        abs = (ImageButton) v.findViewById(R.id.abs_btn);


        leftAnkleFront.setOnClickListener(this);
        leftArmFront.setOnClickListener(this);
        leftLegBottomFront.setOnClickListener(this);
        leftLegTopFront.setOnClickListener(this);
        leftFootFront.setOnClickListener(this);
        rightAnkleFront.setOnClickListener(this);
        rightArmFront.setOnClickListener(this);
        rightLegBottomFront.setOnClickListener(this);
        rightLegTopFront.setOnClickListener(this);
        rightFootFront.setOnClickListener(this);
        sideFront.setOnClickListener(this);
        neckFront.setOnClickListener(this);
        headFront.setOnClickListener(this);
        crotch.setOnClickListener(this);
        chest.setOnClickListener(this);
        abs.setOnClickListener(this);

        intent = new Intent(getActivity(), BodySelectionInfo.class);
        return v;
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.left_ankle_front_btn:
                partInfo.setText("Left Ankle");
                intent.putExtra("Body", "left_ankle");
                startActivity(intent);
                break;
            case R.id.left_arm_front_btn:
                partInfo.setText("Left Arm");
                intent.putExtra("Body", "left_arm");
                startActivity(intent);
                break;
            case R.id.left_foot_front_btn:
                partInfo.setText("Left Foot");
                intent.putExtra("Body", "left_foot");
                startActivity(intent);
                break;
            case R.id.left_leg_bottom_front_btn:
                partInfo.setText("Left Calf");
                intent.putExtra("Body", "left_leg_bottom");
                startActivity(intent);
                break;
            case R.id.left_leg_top_front_btn:
                partInfo.setText("Left Thigh");
                intent.putExtra("Body", "left_leg_top");
                startActivity(intent);
                break;
            case R.id.right_ankle_front_btn:
                partInfo.setText("Right Ankle");
                intent.putExtra("Body", "right_ankle");
                startActivity(intent);
                break;
            case R.id.right_arm_front_btn:
                partInfo.setText("Right Arm");
                intent.putExtra("Body", "right_arm");
                startActivity(intent);
                break;
            case R.id.right_foot_front_btn:
                partInfo.setText("Right Foot");
                intent.putExtra("Body", "right_foot");
                startActivity(intent);
                break;
            case R.id.right_leg_bottom_front_btn:
                partInfo.setText("Right Calf");
                intent.putExtra("Body", "right_leg_bottom");
                startActivity(intent);
                break;
            case R.id.right_leg_top_front_btn:
                partInfo.setText("Right Thigh");
                intent.putExtra("Body", "right_leg_top");
                startActivity(intent);
                break;
            case R.id.head_front_btn:
                partInfo.setText("Head");
                intent.putExtra("Body", "head");
                startActivity(intent);
                break;
            case R.id.abs_btn:
                partInfo.setText("Abs");
                intent.putExtra("Body", "abs");
                startActivity(intent);
                break;
            case R.id.chest_btn:
                partInfo.setText("Chest");
                intent.putExtra("Body", "chest");
                startActivity(intent);
                break;
            case R.id.sides_front_btn:
                partInfo.setText("Sides");
                intent.putExtra("Body", "sides");
                startActivity(intent);
                break;
            case R.id.neck_front_btn:
                partInfo.setText("Neck");
                intent.putExtra("Body", "neck");
                startActivity(intent);
                break;
            case R.id.crotch_btn:
                partInfo.setText("Crotch");
                intent.putExtra("Body", "crotch");
                startActivity(intent);
                break;
            default:
                break;

        }
    }
}
