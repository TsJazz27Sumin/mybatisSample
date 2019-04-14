package sample.mybatis.java.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sample.mybatis.java.dao.mapper.WorkerMapper;
import sample.mybatis.java.model.Worker;

public class SampleDao {

	public static SampleDao instance = new SampleDao();

	private SampleDao () {

	}

	public List<Worker> select() throws SQLException, IOException {

		List<Worker> workerList = null;

		try (var in = Resources.getResourceAsStream("mybatis-config.xml")) {
            var factory = new SqlSessionFactoryBuilder().build(in);

            try (var session = factory.openSession()) {
            	var mapper = session.getMapper(WorkerMapper.class);
                workerList = mapper.selectAll();
            }
        }

        return workerList;
	}

	public void insert() throws SQLException, IOException {

		try (var in = Resources.getResourceAsStream("mybatis-config.xml")) {
            var factory = new SqlSessionFactoryBuilder().build(in);

            try (var session = factory.openSession()) {
            	var mapper = session.getMapper(WorkerMapper.class);
            	var worker = new Worker("0001", "k.jarrett", 73, "music");
            	mapper.insert(worker);
            	session.commit();
            }
        }
	}

	public void update() throws SQLException, IOException {

		try (var in = Resources.getResourceAsStream("mybatis-config.xml")) {
            var factory = new SqlSessionFactoryBuilder().build(in);

            try (var session = factory.openSession()) {
            	var mapper = session.getMapper(WorkerMapper.class);
            	var worker = new Worker("0001", "k.jarrett", 74, "music");
            	mapper.update(worker);
            	session.commit();
            }
        }
	}

	public void delete() throws SQLException, IOException {

		try (var in = Resources.getResourceAsStream("mybatis-config.xml")) {
            var factory = new SqlSessionFactoryBuilder().build(in);

            try (var session = factory.openSession()) {
            	var mapper = session.getMapper(WorkerMapper.class);
            	var worker = new Worker("0001", "k.jarrett", 74, "music");
            	mapper.delete(worker);
            	session.commit();
            }
        }
	}
}
