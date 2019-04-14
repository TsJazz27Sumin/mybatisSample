package sample.mybatis.java;

import java.io.IOException;
import java.sql.SQLException;

import sample.mybatis.java.dao.SampleDao;

public class Program {

	public static void main(String[] args) {

		var dao = SampleDao.instance;

		try {
			dao.insert();

			var workerList = dao.select();

			for (var worker : workerList){

				System.out.println(
	            		String.format(
	            				"id:%s name:%s age:%d department:%s",
	            				worker.getId(), worker.getName(), worker.getAge(), worker.getDepartment()
	            				)
	            		);
			}

			dao.update();

			workerList.addAll(dao.select());

			for (var worker : workerList){

				System.out.println(
	            		String.format(
	            				"id:%s name:%s age:%d department:%s",
	            				worker.getId(), worker.getName(), worker.getAge(), worker.getDepartment()
	            				)
	            		);
			}

			dao.delete();

			workerList = dao.select();

			if(workerList.size() == 0) {
				System.out.println("count = 0");
			}

		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
