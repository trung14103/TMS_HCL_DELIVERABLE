package com.hcl.tms_ver2.service;

import com.hcl.tms_ver2.persistent.domain.Size;
import com.hcl.tms_ver2.persistent.repository.SizeRepository;
import com.hcl.tms_ver2.request.SizeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService{
    private SizeRepository sizeRepository;

    @Autowired
    public SizeServiceImpl(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Override
    public Size findOne(Long sizeId) {
        return sizeRepository.getOne(sizeId);
    }

    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public void addNewSize(SizeRequest sizeRequest) {

    }

    @Override
    public void updateSize(SizeRequest request) {

    }

    @Override
    public void delSize(Long sizeId) {
        Size size = sizeRepository.getOne(sizeId);
        sizeRepository.delete(size);
    }

    @Override
    public List<Size> getListSizeByName(String SizeName) {
        return null;
    }

    @Override
    public List<Size> getListSizeByProductId(Integer productId) {
        return null;
    }
}
