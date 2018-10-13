package controler;

import model.Model;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Plateau {

	//Tableau de 11 cases sur 19


	private static final Plateau instance = new Plateau();


	 private Plateau(){}

	  public static Plateau getInstance(String lvl){

	          return instance;
	      }




}

