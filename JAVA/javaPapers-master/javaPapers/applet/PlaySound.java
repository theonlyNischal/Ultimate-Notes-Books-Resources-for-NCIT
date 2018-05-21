/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class PlaySound extends Applet implements ActionListener{
    Button b1,b2,b3;
    AudioClip sound;
    public void init(){
        b1=new Button("Play");
        b2=new Button("Stop");
        b3=new Button("Loop");
        setLayout(new FlowLayout());
        add(b1);add(b2);add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        sound=getAudioClip(getCodeBase(),"images/alarm01.wav");
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            sound.play();
        }
        else if(e.getSource()==b2){
            sound.stop();
        }
        else if(e.getSource()==b3){
            sound.loop();
        }
    }
}
