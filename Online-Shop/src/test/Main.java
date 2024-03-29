
package test;

import java.text.ParseException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

//import org.lachin.common.LachinCal;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ParseException,
			FileNotFoundException, UnsupportedEncodingException {

		String allfilenames[] = { "Factsituation" };

		// generate UCServices

		for (String filename : allfilenames) {
			PrintWriter writer = new PrintWriter("/home/bitowen13/DEV/" + filename + "UCService.java", "UTF-8");

			writer.println("package accounting.ServiceInterface;");
			writer.println();
			writer.println("import baseService.baseUCService;");
			writer.println("import accounting.Entity." + filename + ";");
			writer.println();
			writer.println("public interface " + filename + "UCService extends baseUCService<" + filename + ">");
			writer.println("{");
			writer.println();
			writer.println();
			writer.println("}");

			writer.close();
		}

		for (String filename : allfilenames) {
			PrintWriter writer = new PrintWriter("/home/bitowen13/DEV/" + filename + "ServiceImpl.java", "UTF-8");

			writer.println("package accounting.Service;");
			writer.println();
			writer.println("import accounting.ServiceInterface." + filename + "UCService;");
			writer.println("import accounting.Entity." + filename + ";");
			writer.println("import baseService.baseUCServiceImpl;");
			writer.println("import common.exception.gException;");
			writer.println("import org.springframework.stereotype.Service;");
			writer.println("import org.springframework.transaction.annotation.Transactional;");
			writer.println();
			writer.println();
			writer.println("@Service");
			writer.println("public class " + filename + "ServiceImpl extends baseUCServiceImpl<" + filename
					+ "> implements " + filename + "UCService");
			writer.println("{");
			writer.println();
			writer.println("\t@Override");
			writer.println("\t@Transactional");
			writer.println("\tpublic String Add(" + filename + " entity) throws Exception, gException ");
			writer.println("\t{");
			// writer.println();
			writer.println("\t\t//do Business Logic HERE");
			writer.println();
			writer.println();
			writer.println("\t\treturn super.Add(entity);");
			writer.println("\t}");
			writer.println();
			writer.println();
			writer.println();
			writer.println("\t@Override");
			writer.println("\t@Transactional");
			writer.println("\tpublic " + filename + " Edit(" + filename + " entity)  throws Exception,gException");
			writer.println("\t{");
			writer.println();
			writer.println("\t\t//do Business Logic HERE");
			writer.println();
			writer.println();
			writer.println("\t\treturn super.Edit(entity);");
			writer.println("\t}");
			writer.println();
			writer.println();
			writer.println();
			writer.println("\t@Override");
			writer.println("\t@Transactional");
			writer.println("\tpublic void Remove(" + filename + " entity)  throws Exception,gException");
			writer.println("\t{");
			writer.println();
			writer.println("\t\t//do Business Logic HERE");
			writer.println();
			writer.println();
			writer.println("\t\tsuper.Remove(entity);");
			writer.println("\t}");
			writer.println();
			writer.println();
			writer.println("}");

			writer.close();
		}
	}

}
