package org.ulv.timeline.service;

import java.util.List;

import org.ulv.timeline.model.Distributor;

public interface DistributorService {

	List<Distributor> getDistributors(Integer id);
}
