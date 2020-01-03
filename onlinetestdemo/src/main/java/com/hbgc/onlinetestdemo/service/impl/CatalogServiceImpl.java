package com.hbgc.onlinetestdemo.service.impl;

import com.hbgc.onlinetestdemo.domian.Catalog;
import com.hbgc.onlinetestdemo.repository.CatalogRepository;
import com.hbgc.onlinetestdemo.service.CatalogService;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl extends BaseServiceImpl<Catalog,Integer, CatalogRepository> implements CatalogService {
}
