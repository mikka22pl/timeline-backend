package org.ulv.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.timeline.model.Distributor;

@Component
public class DistributorDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Distributor> getDistributors(Distributor distributor) {
		return sqlSession.selectList("org.ulv.timeline.dao.DistributorDao.getDistributor", distributor);
	}
}
