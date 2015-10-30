package v11.server.context;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.util.HashMap;

public class AnnotionApplicationContext {
  HashMap<String,Object> objMap = new HashMap<String,Object>();
  
  public AnnotionApplicationContext(String basePackage) throws Exception {
    createObjects(new File("./bin/" + basePackage.replace(".", "/")));
    injectDependencies();
  }
  
  public Object getBean(String name) {
    return objMap.get(name);
  }
  
  private void createObjects(File file) throws Exception {
    System.out.println(file.getCanonicalPath());
    
    File[] subFiles = file.listFiles(new DirectoryOrClassFilter());
    
    for (File f : subFiles) {
      if (f.isDirectory())
        createObjects(f);
      else 
        System.out.println(f.getCanonicalPath());
    }
    
    /*
    Class<?> clazz = null;
    for (Entry<Object,Object> entry : props.entrySet()) {
      clazz = Class.forName((String)entry.getValue());
      objMap.put((String)entry.getKey(), clazz.newInstance());
    }
    */
  }
  
  private void injectDependencies() throws Exception {
    Object[] objList = objMap.values().toArray();
    Object dependency = null;
    
    for (Object obj : objList) {
      for (Method m : obj.getClass().getMethods()) {
        if (!isSetter(m)) continue;
        dependency = findObjectByType(m.getParameterTypes()[0]);
        if (dependency == null) continue;
        m.invoke(obj, dependency);
      }
    }
  }
  
  private boolean isSetter(Method m) {
    if (m.getName().startsWith("set") 
        && m.getParameterTypes().length == 1)
      return true;
    return false;
  }
  
  private Object findObjectByType(Class<?> type) {
    Object[] objList = objMap.values().toArray();
    
    for (Object obj : objList) {
      if (type.isInstance(obj))
        return obj;
    }
    return null;
  }
  
  class DirectoryOrClassFilter implements FileFilter {
    public boolean accept(File pathname) {
      if (pathname.isDirectory())
        return true;
      
      if (pathname.getName().endsWith(".class"))
        return true;
      
      return false;
    }
  }
}
