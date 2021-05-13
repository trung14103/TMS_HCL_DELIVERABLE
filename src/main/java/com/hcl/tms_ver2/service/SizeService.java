package com.hcl.tms_ver2.service;

import com.hcl.tms_ver2.persistent.domain.Size;
import com.hcl.tms_ver2.request.SizeRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface SizeService {
    public Size findOne(Long SizeId);

    public List<Size> getAll();

    public void addNewSize(SizeRequest sizeRequest);

    public void updateSize(SizeRequest sizeRequest);

    @Transactional
    public void delSize(Long SizeId);

    public List<Size> getListSizeByName(String SizeName);

    public List<Size> getListSizeByProductId (Integer productId);
}
