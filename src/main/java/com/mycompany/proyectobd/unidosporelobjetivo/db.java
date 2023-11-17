/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobd.unidosporelobjetivo;


import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;



/**
 *
 * @author angeldvvp
 */
public class db {
     public static final String DEST = "C:/Users/angeldvvp/Desktop/hola.pdf";
      public static void main(String[] args) throws FileNotFoundException {
          try{
     PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
    Document document = new Document(pdf);
    String line = "Hello! Welcome to iTextPdf";
    document.add(new Paragraph(line));
    document.close();

    System.out.println("Awesome PDF just got created.");
          }catch(Exception e){
              System.out.println(e.getMessage());
          }
      }
      }
      