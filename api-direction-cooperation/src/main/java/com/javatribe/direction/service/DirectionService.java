package com.javatribe.direction.service;

import com.javatribe.direction.bean.entity.Direction;
import com.javatribe.direction.mapper.DirectionMapper;
import org.springframework.stereotype.Service;

@Service("directionService")
public class DirectionService extends BaseService<Direction, DirectionMapper> {
}
