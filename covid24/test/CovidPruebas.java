/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import models.GeneralModel;
import models.Municipio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.db.DBConf;

/**
 *
 * @author agos1
 */
public class CovidPruebas {
    
    public CovidPruebas() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DBConf.testMode = true;
        new GeneralModel().startpruebas();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     //@Test
     //public void hello() {}
     
     @Test
     public void readMunicipioTest(){
         Municipio municipio = new Municipio();
         municipio.find(1);
         assertEquals(municipio.getNombre(), "Medellin");
         
     }
     
     @Test
     public void deleteMunicipioTest(){
         Municipio municipio = new Municipio();
         municipio.find(1);
         municipio.delete();
         Municipio municipioValidacion = new Municipio();
         try{
             municipioValidacion.find(1);
             assertTrue(false);
         }catch (Exception e){
             assertTrue(true);
         }
         
     }
}
