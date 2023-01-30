package com.example.joins.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpRepository empRepository;

	@Override
	public List<Emp> findEmpDataByPage(int pageno,int pagesize) {
		Pageable paging = PageRequest.of(pageno, pagesize);
        Page<Emp> pagedResult = empRepository.findAll(paging);
        
        //System.out.println("Page Result: "+pagedResult.toList());
        return pagedResult.toList();
	}

	@Override
	public List<Emp> findEmpDataByRole(String role) {
		return empRepository.findEmpDataByRole(role);
	}

	@Override
	public List<Emp> sortEmpData(int pageno, int pagesize, String sort) {
		Pageable paging = PageRequest.of(pageno, pagesize,Sort.by(sort).ascending());
        Page<Emp> pagedResult = empRepository.findAll(paging);
        return pagedResult.toList();
	}

}
