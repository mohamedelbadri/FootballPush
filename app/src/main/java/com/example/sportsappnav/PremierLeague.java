package com.example.sportsappnav;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;



public class PremierLeague extends Fragment {

    GridLayout mainGrid;
    Integer teamID;
    TextView data;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_premier_league, container, false);
        View view2 = inflater.inflate(R.layout.add_page, container, false);



        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);
        //data = (TextView) view2.findViewById(R.id.textView2);


        //Set Event
        setSingleEvent(mainGrid);



        return view;
    }

    private void setSingleEvent(GridLayout mainGrid) {

        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int[] finalI = {i};
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final addPage addPage = new addPage();
                    final calendarPush calendar = new calendarPush();
                    fetchData(finalI);
                    final Dialog fbDialogue = new Dialog(getContext());
                    //fbDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));
                    fbDialogue.setContentView(R.layout.add_page);
                    data = fbDialogue.findViewById(R.id.textView2);
                    data.setTextColor(Color.rgb(0,0,0));
                    fbDialogue.show();
                    fbDialogue.setCancelable(true);
                    fbDialogue.setCanceledOnTouchOutside(true);
                    addPageParams params = new addPageParams(getContext(), finalI[0], data);
                    addPage.execute(params);
                    Button btnsubmit = (Button) fbDialogue.findViewById(R.id.btn_submit);
                    btnsubmit.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            calendar.push(getContext(), addPage.returnResultArray(), addPage.returnTimeStampArray(), addPage.returnVenueArray() );
                            fbDialogue.dismiss();
                        }
                    });
                }
            });

        }
    }

    private void fetchData(int [] finalI){

        Resources r = getResources();

        //card index to teamID (teamID number from APIFootball)

        //manunited
        if (finalI[0] == 0) {
            finalI[0] = 33;};
        //liverpool
        if (finalI[0] == 1) {
            finalI[0] = r.getInteger(R.integer.liverpool);};
        //chelsea
        if (finalI[0] == 2) {
            finalI[0] = r.getInteger(R.integer.chelsea);};
        //mancity
        if (finalI[0] == 3) {
            finalI[0] = r.getInteger(R.integer.mancity);};
        //tottenham
        if (finalI[0] == 4) {
            finalI[0] = r.getInteger(R.integer.tottenham);};
        //arsenal
        if (finalI[0] == 5) {
            finalI[0] = r.getInteger(R.integer.arsenal);};
        //everton
        if (finalI[0] == 6) {
            finalI[0] = r.getInteger(R.integer.everton);};
        //wolves
        if (finalI[0] == 7) {
            finalI[0] = r.getInteger(R.integer.wolves);};
        //leiscter
        if (finalI[0] == 8) {
            finalI[0] = r.getInteger(R.integer.leiscter);};
        //watford
        if (finalI[0] == 9) {
            finalI[0] = r.getInteger(R.integer.watford);};
        //palace
        if (finalI[0] == 10) {
            finalI[0] = r.getInteger(R.integer.palace);};
        //burnley
        if (finalI[0] == 11) {
            finalI[0] = r.getInteger(R.integer.burnley);};
        //southampton
        if (finalI[0] == 12) {
            finalI[0] = r.getInteger(R.integer.southampton);};
        //newcastle
        if (finalI[0] == 13) {
            finalI[0] = r.getInteger(R.integer.newcastle);};
        //brighton
        if (finalI[0] == 14) {
            finalI[0] = r.getInteger(R.integer.brighton);};
        //westham
        if (finalI[0] == 15) {
            finalI[0] = r.getInteger(R.integer.westham);};
        //astonvilla
        if (finalI[0] == 16) {
            finalI[0] = r.getInteger(R.integer.astonvilla);};
        //sheffield
        if (finalI[0] == 17) {
            finalI[0] = r.getInteger(R.integer.sheffield);};
        //bournemouth
        if (finalI[0] == 18) {
            finalI[0] = r.getInteger(R.integer.bournemouth);};
        //norwich
        if (finalI[0] == 19) {
            finalI[0] = r.getInteger(R.integer.norwich);};

    }
}
