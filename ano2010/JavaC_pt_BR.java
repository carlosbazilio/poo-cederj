package br.cederj.comp.ano2010;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.Diagnostic.Kind;

public class JavaC_pt_BR {
	public static void main(String[] args) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
	    StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, new Locale("pt", "BR"), null);
	    
	    File[] files1 = { new File("/Users/carlosbazilio/Aulas/CEDERJ/Provas/Gabaritos/Questoes/src/br/cederj/comp/ano2010/Simplificada.java") } ; // input for first compilation task
	    
	    Iterable<JavaFileObject> compilationUnits1 =
	           (Iterable<JavaFileObject>) (fileManager.getJavaFileObjectsFromFiles(Arrays.asList(files1)));
	    compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits1).call();
	    
	    for (Diagnostic diagnostic : diagnostics.getDiagnostics())
//	           System.out.format("Error on line %d in %d%n",
//	                             diagnostic.getLineNumber(),
//	                             ((FileObject) diagnostic.getSource()).toUri());
	    	if (diagnostic.getKind() == Kind.ERROR) {
	    		System.out.println(diagnostic.getMessage(new Locale("pt", "BR")));
	    		System.out.println(diagnostic.getLineNumber());
	    		System.out.println(diagnostic.getCode());
	    		System.out.println(diagnostic.getColumnNumber());
	    		System.out.println(diagnostic.getSource());
	    	}
	    
	    try {
			fileManager.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Locale[] s = Locale.getAvailableLocales();
//	      System.out.println("Supported locales: ");
//	      for (int i=0; i<s.length; i++) {
//	         System.out.println("   "+s[i].getLanguage()+", "
//	            +s[i].getCountry()+", "+s[i].getVariant()+", "
//	            +s[i].getDisplayName());
//	      }

	}
}
