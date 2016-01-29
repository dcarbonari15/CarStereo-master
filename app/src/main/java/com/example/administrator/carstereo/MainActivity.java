package com.example.administrator.carstereo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.ToggleButton;


public class MainActivity extends Activity implements
        View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnLongClickListener{

    protected ToggleButton powerButton;
    protected Button preset1;
    protected Button preset2;
    protected Button preset3;
    protected Button preset4;
    protected Button preset5;
    protected Button preset6;
    protected Button ejectButton;
    protected Switch amFmSwitch;
    protected SeekBar volumeSeekBar;
    protected SeekBar frequencySeekBar;
    protected TextView radioStationFrequencyText;
    protected TextView volumeValuetext;
    protected TextView AMText;
    protected TextView FMText;
    protected double[] presetsFM = new double[6];
    protected int[] presetsAM = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powerButton = (ToggleButton)findViewById(R.id.powerButton);
        powerButton.setOnClickListener(this);

        amFmSwitch = (Switch)findViewById(R.id.AMFMSwitch);
        amFmSwitch.setOnClickListener(this);
        amFmSwitch.setEnabled(false);

        frequencySeekBar = (SeekBar)findViewById(R.id.frequencySeekBar);
        frequencySeekBar.setOnSeekBarChangeListener(this);
        frequencySeekBar.setEnabled(false);

        volumeSeekBar = (SeekBar)findViewById(R.id.VolumeSeekBar);
        volumeSeekBar.setOnSeekBarChangeListener(this);
        volumeSeekBar.setEnabled(false);

        volumeValuetext = (TextView)findViewById(R.id.VolumeValue);

        AMText = (TextView)findViewById(R.id.AMText);

        FMText = (TextView)findViewById(R.id.FMText);

        radioStationFrequencyText = (TextView)findViewById(R.id.radioStationFrequency);

        preset1 = (Button)findViewById(R.id.Preset1);
        preset1.setOnClickListener(this);
        preset1.setOnLongClickListener(this);
        
        preset2 = (Button)findViewById(R.id.Preset2);
        preset2.setOnClickListener(this);
        preset2.setOnLongClickListener(this);
        
        preset3 = (Button)findViewById(R.id.Preset3);
        preset3.setOnClickListener(this);
        preset3.setOnLongClickListener(this);
        
        preset4 = (Button)findViewById(R.id.Preset4);
        preset4.setOnClickListener(this);
        preset4.setOnLongClickListener(this);
        
        preset5 = (Button)findViewById(R.id.Preset5);
        preset5.setOnClickListener(this);
        preset5.setOnLongClickListener(this);
        
        preset6 = (Button)findViewById(R.id.Preset6);
        preset6.setOnClickListener(this);
        preset6.setOnLongClickListener(this);
        
        ejectButton = (Button)findViewById(R.id.ejectButton);

        presetsAM[0] = 550;
        presetsAM[1] = 600;
        presetsAM[2] = 650;
        presetsAM[3] = 700;
        presetsAM[4] = 750;
        presetsAM[5] = 800;

        presetsFM[0] = 90.9;
        presetsFM[1] = 92.9;
        presetsFM[2] = 94.9;
        presetsFM[3] = 96.9;
        presetsFM[4] = 98.9;
        presetsFM[5] = 100.9;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.powerButton) {
            if (powerButton.isChecked()) {
                preset1.setTextColor(0xFFFF0000);
                powerButton.setTextColor(0xFFFF0000);
                preset2.setTextColor(0xFFFF0000);
                preset3.setTextColor(0xFFFF0000);
                preset4.setTextColor(0xFFFF0000);
                preset5.setTextColor(0xFFFF0000);
                preset6.setTextColor(0xFFFF0000);
                ejectButton.setTextColor(0xFFFF0000);
                amFmSwitch.setEnabled(true);
                frequencySeekBar.setEnabled(true);
                volumeSeekBar.setEnabled(true);

            } else {
                preset1.setTextColor(0xFFFFFFFF);
                powerButton.setTextColor(0xFFFFFFFF);
                preset2.setTextColor(0xFFFFFFFF);
                preset3.setTextColor(0xFFFFFFFF);
                preset4.setTextColor(0xFFFFFFFF);
                preset5.setTextColor(0xFFFFFFFF);
                preset6.setTextColor(0xFFFFFFFF);
                ejectButton.setTextColor(0xFFFFFFFF);
                FMText.setTextColor(0xFFFFFFFF);
                AMText.setTextColor(0xFFFFFFFF);
                amFmSwitch.setEnabled(false);
                frequencySeekBar.setEnabled(false);
                volumeSeekBar.setEnabled(false);
            }
        }else if(v.getId() == R.id.AMFMSwitch) {
            int progress = frequencySeekBar.getProgress();
            if(powerButton.isChecked()) {
                if (amFmSwitch.isChecked()) {
                    AMText.setTextColor(0xFFFFFFFF);
                    FMText.setTextColor(0xFFFF0000);
                    frequencySeekBar.setMax(198);
                    radioStationFrequencyText.setText("" + ((double)(progress + 881) / 10.0) + " FM");

                } else {
                    FMText.setTextColor(0xFFFFFFFF);
                    AMText.setTextColor(0xFFFF0000);
                    frequencySeekBar.setMax(117);
                    radioStationFrequencyText.setText("" + ((progress + 53) * 10) + " AM");
                }
            }else{
                FMText.setTextColor(0xFFFFFFFF);
                AMText.setTextColor(0xFFFFFFFF);
            }
        }else if(v.getId() == R.id.Preset1){
            if(powerButton.isChecked()){
                if(amFmSwitch.isChecked()){
                    frequencySeekBar.setProgress((int) presetsFM[0]);
                    radioStationFrequencyText.setText("" + presetsFM[0] + " FM");
                }else{
                    radioStationFrequencyText.setText("" + presetsAM[0] + " AM");
                    frequencySeekBar.setProgress((presetsAM[0] / 10) - 53);
                }
            }

        }else if(v.getId() == R.id.Preset2){
            if(powerButton.isChecked()){
                if(amFmSwitch.isChecked()){
                    frequencySeekBar.setProgress((int)presetsFM[1]);
                    radioStationFrequencyText.setText("" + presetsFM[1] + " FM");
                }else{
                    radioStationFrequencyText.setText("" + presetsAM[1] + " AM");
                    frequencySeekBar.setProgress((presetsAM[1] / 10) - 53);
                }
            }

        }else if(v.getId() == R.id.Preset3){
            if(powerButton.isChecked()){
                if(amFmSwitch.isChecked()){
                    frequencySeekBar.setProgress((int)presetsFM[2]);
                    radioStationFrequencyText.setText("" + presetsFM[2] + " FM");
                }else{
                    radioStationFrequencyText.setText("" + presetsAM[2] + " AM");
                    frequencySeekBar.setProgress((presetsAM[2] / 10) - 53);
                }
            }

        }else if(v.getId() == R.id.Preset4){
            if(powerButton.isChecked()){
                if(amFmSwitch.isChecked()){
                    frequencySeekBar.setProgress((int)presetsFM[3]);
                    radioStationFrequencyText.setText("" + presetsFM[3] + " FM");
                }else{
                    radioStationFrequencyText.setText("" + presetsAM[3] + " AM");
                    frequencySeekBar.setProgress((presetsAM[3] / 10) - 53);
                }
            }

        }else if(v.getId() == R.id.Preset5){
            if(powerButton.isChecked()){
                if(amFmSwitch.isChecked()){
                    frequencySeekBar.setProgress((int)presetsFM[4]);
                    radioStationFrequencyText.setText("" + presetsFM[4] + " FM");
                }else{
                    radioStationFrequencyText.setText("" + presetsAM[4] + " AM");
                    frequencySeekBar.setProgress((presetsAM[4] / 10) - 53);
                }
            }

        }else if(v.getId() == R.id.Preset6){
            if(powerButton.isChecked()){
                if(amFmSwitch.isChecked()){
                    frequencySeekBar.setProgress((int)presetsFM[5]);
                    radioStationFrequencyText.setText("" + presetsFM[5] + " FM");
                }else{
                    radioStationFrequencyText.setText("" + presetsAM[5] + " AM");
                    frequencySeekBar.setProgress((presetsAM[5] / 10) - 53);
                }
            }

        }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar == this.frequencySeekBar){
            if(this.AMText.getCurrentTextColor() == 0xFFFF0000){
                frequencySeekBar.setMax(117);
                radioStationFrequencyText.setText("" + ((progress + 53) * 10) + " AM");
            }else if(this.AMText.getCurrentTextColor() == 0xFFFFFFFF){
                frequencySeekBar.setMax(198);
                if(progress % 2 == 1) {
                    radioStationFrequencyText.setText("" + ((double) (progress + 880) / 10.0) + " FM");
                }else{
                    radioStationFrequencyText.setText("" + ((double) (progress + 881) / 10.0) + " FM");
                }
            }
        }else if(seekBar == this.volumeSeekBar){
            volumeSeekBar.setMax(100);
            volumeValuetext.setText("" + progress);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onLongClick(View v) {
        double newStationFM = ((double)(frequencySeekBar.getProgress() + 881) / 10.0);
        int newStationAM = ((frequencySeekBar.getProgress() + 53) * 10);
        if(powerButton.isChecked()) {
            if (v.getId() == R.id.Preset1) {
                if (amFmSwitch.isChecked()) {
                    presetsFM[0] = newStationFM;
                } else {
                    presetsAM[0] = newStationAM;
                }
                radioStationFrequencyText.setText(radioStationFrequencyText.getText() + " saved");
            } else if (v.getId() == R.id.Preset2) {
                if (amFmSwitch.isChecked()) {
                    presetsFM[1] = newStationFM;
                } else {
                    presetsAM[1] = newStationAM;
                }
                radioStationFrequencyText.setText(radioStationFrequencyText.getText() + " saved");
            } else if (v.getId() == R.id.Preset3) {
                if (amFmSwitch.isChecked()) {
                    presetsFM[2] = newStationFM;
                } else {
                    presetsAM[2] = newStationAM;
                }
                radioStationFrequencyText.setText(radioStationFrequencyText.getText() + " saved");
            } else if (v.getId() == R.id.Preset4) {
                if (amFmSwitch.isChecked()) {
                    presetsFM[3] = newStationFM;
                } else {
                    presetsAM[3] = newStationAM;
                }
                radioStationFrequencyText.setText(radioStationFrequencyText.getText() + " saved");
            } else if (v.getId() == R.id.Preset5) {
                if (amFmSwitch.isChecked()) {
                    presetsFM[4] = newStationFM;
                } else {
                    presetsAM[4] = newStationAM;
                }
                radioStationFrequencyText.setText(radioStationFrequencyText.getText() + " saved");
            } else if (v.getId() == R.id.Preset6) {
                if (amFmSwitch.isChecked()) {
                    presetsFM[5] = newStationFM;
                } else {
                    presetsAM[5] = newStationAM;
                }
                radioStationFrequencyText.setText(radioStationFrequencyText.getText() + " saved");
            }
        }

        return true;
    }
}
