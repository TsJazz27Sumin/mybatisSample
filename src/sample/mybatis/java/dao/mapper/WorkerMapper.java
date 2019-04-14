package sample.mybatis.java.dao.mapper;

import java.util.List;

import sample.mybatis.java.model.Worker;

public interface WorkerMapper {

	List<Worker> selectAll();
	void insert(Worker worker);
	void update(Worker worker);
	void delete(Worker worker);
}
