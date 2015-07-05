package com.tecsup.spring.jdbc;

import com.tecsup.spring.jdbc.dao.ProgramaDAO;
import com.tecsup.spring.jdbc.model.Programa;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       //ApplicationContext cntx = new ClassPathXmlApplicationContext("jdbc_db.xml");
        ApplicationContext cntx = new ClassPathXmlApplicationContext("hibernet_db.xml");
       ProgramaDAO dao = (ProgramaDAO) cntx.getBean("programaDAO");
       //App.guardar(dao);
       //App.actualizar(dao);
       //App.eliminar(dao);
       App.listar(dao);
    }
      public static void guardar (ProgramaDAO dao){
       Programa programa = new Programa();
       programa.setNombre("BryanH");
       programa.setDescripcion("xyz");
       programa.setCodigo("201");
       dao.insert(programa);
       System.out.println(programa.getId());
   }
   
   public static void listar(ProgramaDAO dao) {
       List<Programa> programas = dao.list();
       
       for (Programa programa : programas){
           System.out.println(programa.getNombre() +" "+ programa.getId());
       }
   }
   public static void actualizar(ProgramaDAO dao) {
       Programa programa = dao.get(22L);   
       String nombre = programa.getNombre();
       programa.setNombre("Programa Modificado "+nombre);      
       dao.update(programa);
       System.out.println(programa.getNombre() +" "+ programa.getId());
   }
   public static void eliminar(ProgramaDAO dao) {
       Programa programa = dao.get(22L);
       dao.delete(programa);       
   }
   
   
}
