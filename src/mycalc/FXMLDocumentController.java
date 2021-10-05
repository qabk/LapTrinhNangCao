/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package mycalc;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mycalc.BuiltFunction.*;
/**
 *
 * @author Admin
 */
public class FXMLDocumentController implements Initializable {
    private String Output = new String("");
    private String tmp = new String("");
    private String AnsValue = "0";
    @FXML
    private Button Num1, Num2, Num3, Num4, Num5,
                   Num6, Num7, Num8, Num9, Num0,
                   LeftRound, RightRound, Plus, Minus, Multiply,
                   Divide, Equal, Ans, Delete, AC, Exp, Dot;
    
    @FXML
    private TextField Display;
    @FXML
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void handle1(ActionEvent event)
    {
        Output += Num1.getText().charAt(0);
        Display.setText(Output);
        System.out.println(Output);
    }
    
    public void handle2(ActionEvent event)
    {
        Output += Num2.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handle3(ActionEvent event)
    {
        Output += Num3.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handle4(ActionEvent event)
    {
        Output += Num4.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handle5(ActionEvent event)
    {
        Output += Num5.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handle6(ActionEvent event)
    {
        Output += Num6.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handle7(ActionEvent event)
    {
        Output += Num7.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handle8(ActionEvent event)
    {
        Output += Num8.getText().charAt(0);
        Display.setText(Output);
    }
    public void handle9(ActionEvent event)
    {
        Output += Num9.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handle0(ActionEvent event)
    {
        Output += Num0.getText().charAt(0);
        Display.setText(Output);
    }
    public void handleLeftRound(ActionEvent event)
    {
        Output += LeftRound.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handleRightRound(ActionEvent event)
    {
        Output += RightRound.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handlePlus(ActionEvent event)
    {
        Output += Plus.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handleMinus(ActionEvent event)
    {
        Output += Minus.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handleMulti(ActionEvent event)
    {
        Output += Multiply.getText().charAt(0);
        Display.setText(Output);
    }
    public void handleDivide(ActionEvent event)
    {
        Output += Divide.getText().charAt(0);
        Display.setText(Output);
        System.out.println(Output);
    }
    public void handleEqual(ActionEvent event)
    {
        String temp = new String(BuiltFunction.infixToPostfix(Output));
        
        Vector<String> v =BuiltFunction.inputTransform(temp);
        System.out.println(v);
        Output = BuiltFunction.computePostfix(v);
        if(!Output.equals("syntax err") )
        {
            AnsValue = Output;
        }
        Display.setText(Output);
    }
    
    public void handleAns(ActionEvent event)
    {
       
        Display.setText(AnsValue);
    }
    
    public void handleDel(ActionEvent event)
    {
        if(Output.length() <= 1)
        {
            Output = "";
        }
        else
        {
            Output = Output.substring(0, Output.length()-1);
        }
        
        Display.setText(Output);
    }
    
    public void handleAC(ActionEvent event)
    {
        Output = "";
        Display.setText(Output);
    }
  
    public void handleExp(ActionEvent event)
    {
        Output += Exp.getText().charAt(0);
        Display.setText(Output);
    }
    
    public void handleDot(ActionEvent event)
    {
        Output += Dot.getText().charAt(0);
        Display.setText(Output);
    }
}

