package org.ulv.timeline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.timeline.dao.DistributorDao;
import org.ulv.timeline.model.Distributor;

@Service("distributorService")
public class DistributorServiceImpl implements DistributorService {

	@Autowired
	private DistributorDao distributorDao;
	
	@Override
	public List<Distributor> getDistributors(Integer id) {
		Distributor dist = new Distributor();
		dist.setId(id);
		
		return distributorDao.getDistributors(dist);
	}

}
