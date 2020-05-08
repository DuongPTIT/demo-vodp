package com.viettel.democdc.Services;

import com.viettel.democdc.Domain.RelyMessage;
import com.viettel.democdc.Repositories.RelyMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelyMessageService {

    @Autowired
    private RelyMessageRepository relyMessageRepository;

    public List<RelyMessage> getAllRely() {
        return relyMessageRepository.findAll();
    }
}
