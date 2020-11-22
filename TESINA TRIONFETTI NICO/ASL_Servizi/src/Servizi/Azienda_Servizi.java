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
@Path("Azienda")

public class Azienda_Servizi {
	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAll()
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="SELECT * FROM aziende;";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);
		return json;
	}

	@Path("getAzienda/P_IVA={id_P_IVA}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAzienda_P_IVA(@PathParam("id_P_IVA")String id_P_IVA)
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="SELECT * FROM aziende WHERE P_IVA=\""+id_P_IVA+"\";";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("insertAzienda/P_IVA={id_p_iva}&CF={id_cf}& RagSociale={id_r_soc}&Telefono={id_telefono}&Email={id_email}&Fax={id_fax}&Provincia={id_provincia}&Citta={id_citta}&Indirizzo={id_indirizzo}&TipologiaAzienda={id_t_azienda}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertAzienda(@PathParam("id_p_iva")String id_p_iva,@PathParam("id_cf")String id_cf,@PathParam("id_r_soc")String id_r_soc,@PathParam("id_telefono")String id_telefono,@PathParam("id_email")String id_email,@PathParam("id_fax")String id_fax,@PathParam("id_provincia")String id_provincia,@PathParam("id_citta")String id_citta,@PathParam("id_indirizzo")String id_indirizzo,@PathParam("id_t_azienda")String id_t_azienda)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="INSERT INTO aziende(P_IVA,CF, RagSociale, Telefono, Email, Fax, Provincia, Citta, Indirizzo, TipologiaAzienda) VALUES (\""+id_p_iva+"\", \""+id_cf+"\", \""+id_r_soc+"\" , \""+id_telefono+"\", \""+id_email+"\" , \""+id_fax+"\", \""+id_provincia+"\", \""+id_citta+"\" , \""+id_indirizzo+"\", \""+id_t_azienda+"\");";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("updateAzienda/NP_IVA={id_Np_iva}&Vp_iva={id_Vp_iva}&CF={id_cf}&RagSociale={id_r_soc}&Telefono={id_telefono}&Email={id_email}&Fax={id_fax}&Provincia={id_provincia}&Citta={id_citta}&Indirizzo={id_indirizzo}&TipologiaAzienda={id_t_azienda}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertAzienda(@PathParam("id_Np_iva")String id_Np_iva,@PathParam("id_Vp_iva")String id_Vp_iva,@PathParam("id_cf")String id_cf,@PathParam("id_r_soc")String id_r_soc,@PathParam("id_telefono")String id_telefono,@PathParam("id_email")String id_email,@PathParam("id_fax")String id_fax,@PathParam("id_provincia")String id_provincia,@PathParam("id_citta")String id_citta,@PathParam("id_indirizzo")String id_indirizzo,@PathParam("id_t_azienda")String id_t_azienda)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="UPDATE aziende SET P_IVA = \""+id_Np_iva+"\", CF = \""+id_cf+"\", RagSociale = \""+id_r_soc+"\", `Telefono` = \""+id_telefono+"\", Email = \""+id_email+"\", Fax = \""+id_fax+"\",Provincia = \""+id_provincia+"\",Citta = \""+id_citta+"\",Indirizzo = \""+id_indirizzo+"\",TipologiaAzienda = \""+id_t_azienda+"\" WHERE aziende.P_IVA = \""+id_Vp_iva+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("deleteAzienda/P_IVA={id_p_iva}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	
	public String deleteAzienda(@PathParam("id_p_iva")String id_p_iva)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="DELETE FROM aziende WHERE P_IVA=\""+id_p_iva+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}

	

}