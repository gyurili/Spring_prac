package com.example.secondproject.repository;


import com.example.secondproject.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MemberRepository extends CrudRepository<Member, Long> {

}
