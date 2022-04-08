package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface SystemDao extends ModelDao {
	public StoreDao<TestDao> getStoreTest();
	public StoreDao<ProtocolDao> getStoreProtocol();
}