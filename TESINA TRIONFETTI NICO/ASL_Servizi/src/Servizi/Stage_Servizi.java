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
@Path("Stage")

public class Stage_Servizi {
	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAll()
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql= "SELECT * FROM stage";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("insertStage/NumStage={id_numstage}&Stu_CF={id_stu_cf}&P_IVA={id_p_iva}&AnSc={id_anSc}&Tut_CF={id_tut_cf}&Doc_CF={id_doc_cf}&Data_I={id_data_i}&Data_F={id_data_f}&Tipologia={id_tipologia}&Assicurazione={id_assicurazione}&N_poliz={id_n_poliz}&Classe={id_classe}&Sezione={id_sezione}&Mod4={id_mod4}&Mod5={id_mod5}&Mod9={id_mod9}&Mod8={id_mod8}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertStage(@PathParam("id_numstage")String id_numstage,@PathParam("id_stu_cf")String id_stu_cf,@PathParam("id_p_iva")String id_p_iva,@PathParam("id_anac")String id_ansc,@PathParam("id_tut_cf")String id_tut_cf,@PathParam("id_doc_cf")String id_doc_cf,@PathParam("id_data_i")String id_data_i,@PathParam("id_data_f")String id_data_f,@PathParam("id_tipologia")String id_tipologia,@PathParam("id_assicurazione")String id_assicurazione,@PathParam("id_n_poliz")String id_n_poliz,@PathParam("id_classe")String id_classe,@PathParam("id_sezione")String id_sezione,@PathParam("id_mod4")String id_mod4,@PathParam("id_mod5")String id_mod5,@PathParam("id_mod9")String id_mod9,@PathParam("id_mod8")String id_mod8)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="INSERT INTO stage(NumStage, Stu_CF, P_IVA, AnSc, Tut_CF, Doc_CF, Data_I, Data_F, Tipologia, Assicurazione, N_poliz, Classe, Sezione, Mod4, Mod5, Mod9, Mod8) VALUES (\""+id_numstage+"\",\""+id_stu_cf+"\",\""+id_p_iva+"\",\""+id_ansc+"\",\""+id_tut_cf+"\",\""+id_doc_cf+"\",\""+id_data_i+"\",\""+id_data_f+"\",\""+id_tipologia+"\",\""+id_assicurazione+"\",\""+id_n_poliz+"\",\""+id_classe+"\",\""+id_sezione+"\",\""+id_mod4+"\",\""+id_mod5+"\",\""+id_mod9+"\",\""+id_mod8+"\");";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("deleteStage/NumStage={id_numstage}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	
	public String deleteStage(@PathParam("id_numstage")String id_numstage)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="DELETE FROM stage WHERE Numstage= \""+id_numstage+"\";";//ATTENZIONE
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("updateStage/VNumStage={id_Vnumstage}&NNumStage={id_Nnumstage}&Stu_CF={id_stu_cf}&P_IVA={id_p_iva}&AnSc={id_ansc}&Tut_CF={id_tut_cf}&Doc_CF={id_doc_cf}&Data_I={id_data_i}&Data_F={id_data_f}&Tipologia={id_tipologia}&Assicurazione={id_assicurazione}&N_poliz={id_n_poliz}&Classe={id_classe}&Sezione={id_sezione}&Mod4={id_mod4}&Mod5={id_mod5}&Mod9={id_mod9}&Mod8={id_mod8}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	
	public String updateStage(@PathParam("id_Nnumstage")String id_Nnumstage,@PathParam("id_Vnumstage")String id_Vnumstage,@PathParam("id_stu_cf")String id_stu_cf,@PathParam("id_p_iva")String id_p_iva,@PathParam("id_ansc")String id_ansc,@PathParam("id_tut_cf")String id_tut_cf,@PathParam("id_doc_cf")String id_doc_cf,@PathParam("id_data_i")String id_data_i,@PathParam("id_data_f")String id_data_f,@PathParam("id_tipologia")String id_tipologia,@PathParam("id_assicurazione")String id_assicurazione,@PathParam("id_n_poliz")String id_n_poliz,@PathParam("id_classe")String id_classe,@PathParam("id_sezione")String id_sezione,@PathParam("id_mod4")String id_mod4,@PathParam("id_mod5")String id_mod5,@PathParam("id_mod9")String id_mod9,@PathParam("id_mod8")String id_mod8)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="UPDATE stage SET NumStage=\""+id_Nnumstage+"\",Stu_CF=\""+id_stu_cf+"\",P_IVA=\""+id_p_iva+"\",AnSc=\""+id_ansc+"\",Tut_CF=\""+id_tut_cf+"\",Doc_CF=\""+id_doc_cf+"\",Data_I=\""+id_data_i+"\",Data_F=\""+id_data_f+"\",Tipologia=\""+id_tipologia+"\",Assicurazione=\""+id_assicurazione+"\",N_poliz=\""+id_n_poliz+"\",Classe=\""+id_classe+"\",Sezione=\""+id_sezione+"\",Mod4=\""+id_mod4+"\",Mod5=\""+id_mod5+"\",Mod9=\""+id_mod9+"\",Mod8=\""+id_mod8+"\" WHERE NumStage = \""+id_Vnumstage+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}

}
