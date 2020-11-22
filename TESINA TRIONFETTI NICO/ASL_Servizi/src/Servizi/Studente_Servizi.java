package Servizi;

import java.io.IOException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Main.Main;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("Studente")

public class Studente_Servizi {
	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAll()
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="SELECT * FROM studenti ;";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);;
		return json;
	}
	
	@Path("insertStudente/CF={id_CF}&Matricola={id_Matricola}&Data_N={id_Data_N}&Comune_nascita={id_Comune_nascita}&comune_residenza={id_Comune_residenza}&Indirizzo={id_Indirizzo}&Prov={id_Prov}&Cap={id_Cap}&Sesso={id_Sesso}&Classe={id_Classe}&Sezione={id_Sezione}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertStudente(@PathParam("id_CF")String id_CF,@PathParam("id_Matricola")String id_Matricola,@PathParam("id_Data_N")String id_Data_N,@PathParam("id_Comune_nascita")String id_Comune_nascita,@PathParam("id_Comune_residenza")String id_Comune_residenza,@PathParam("id_Indirizzo")String id_Indirizzo,@PathParam("id_Prov")String id_Prov,@PathParam("id_Cap")String id_Cap,@PathParam("id_Sesso")String id_Sesso,@PathParam("id_Classe")String id_Classe,@PathParam("id_Sezione")String id_Sezione)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="INSERT INTO studenti(CF, Matricola, Data_N, Comune_nascita, Comune_residenza, Indirizzo, Prov, Cap, Sesso, Classe, Sezione) VALUES (\""+id_CF+"\", \""+id_Matricola+"\", \""+id_Data_N+"\", \""+id_Comune_nascita+"\", \""+id_Comune_residenza+"\", \""+id_Indirizzo+"\", \""+id_Prov+"\", \""+id_Cap+"\", \""+id_Sesso+"\", \""+id_Classe+"\",\""+id_Sezione+"\");";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("insertStudente/NCF={id_Ncf}&VCF={id_Vcf}&Matricola={id_matricola}&Data_N={id_data_n}&Comune_nascita={id_comune_nascita}&comune_residenza={id_comune_residenza}&Indirizzo={id_indirizzo}&Prov={id_prov}&Cap={id_cap}&Sesso={id_sesso}&Classe={id_classe}&Sezione={id_sezione}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	
	public String updateStudente(@PathParam("id_Ncf")String id_Ncf,@PathParam("id_Vcf")String id_Vcf,@PathParam("id_matricola")String id_matricola,@PathParam("id_data_n")String id_data_n,@PathParam("id_comune_nascita")String id_comune_nascita,@PathParam("id_Comune_residenza")String id_comune_residenza,@PathParam("id_indirizzo")String id_indirizzo,@PathParam("id_prov")String id_prov,@PathParam("id_cap")String id_cap,@PathParam("id_sesso")String id_sesso,@PathParam("id_classe")String id_classe,@PathParam("id_sezione")String id_sezione)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="UPDATE studenti SET CF=\""+id_Ncf+"\",Matricola=\""+id_matricola+"\",Data_N=\""+id_data_n+"\",Comune_nascita=\""+id_comune_nascita+"\",Comune_residenza=\""+id_comune_residenza+"\",Indirizzo=\""+id_indirizzo+"\",Prov=\""+id_prov+"\",Cap=\""+id_cap+"\",Sesso=\""+id_sesso+"\",Classe=\""+id_classe+"\",Sezione=\""+id_sezione+"\" WHERE CF= \""+id_Vcf+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}

    @Path("deleteStudente/CF={id_cf}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	
	public String deleteStudente_CF(@PathParam("id_cf")String id_cf)throws IOException
	{
    	String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="DELETE FROM studenti WHERE CF = \""+id_cf+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
    
    

}