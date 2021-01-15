/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_01_tema04_ed;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author francis
 */
public class Ejercicio_01_Tema04_ED 
{
    private static byte[] bufer = new byte[1000];
    private static String NombreArchivo = "fichero.dat";
    private static FileInputStream ArchivoEntrada = null;
    private static BufferedInputStream BuferEntrada = null;

    public static void InicializandoArchivos() throws FileNotFoundException
    {
        ArchivoEntrada = new FileInputStream(NombreArchivo);
        BuferEntrada = new BufferedInputStream(ArchivoEntrada);
    }
    
    public static int MostrarArchivosTexto() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = ArchivoEntrada.read(bufer)) != -1) 
        {
            System.out.println(new String(bufer));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            InicializandoArchivos();
            
            int total = MostrarArchivosTexto();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( BuferEntrada != null && ArchivoEntrada != null )
                {
                    ArchivoEntrada.close();
                    BuferEntrada.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
