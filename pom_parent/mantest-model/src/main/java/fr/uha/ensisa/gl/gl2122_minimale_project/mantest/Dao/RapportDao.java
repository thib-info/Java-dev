package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

import java.util.Map;

public interface RapportDao {
	public Map<String, Object> generate(long id);
	public float statPositiveTest(long id);	
}
