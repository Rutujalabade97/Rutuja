package com.cg.apartment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.apartment.entities.UserEntity;
import com.cg.apartment.exception.DuplicateRecordException;
import com.cg.apartment.exception.RecordNotFoundException;
import com.cg.apartment.repository.UserDAOInt;

@Service
public class UserServiceImpl implements UserServiceInt
{
	@Autowired
	UserDAOInt userdao;

	@Override
	public UserEntity findByPk(long id) throws RecordNotFoundException {
		Optional<UserEntity> user=userdao.findById(id);
		if(!user.isPresent())
			throw new RecordNotFoundException("Record not found");
		else
			return user.get();
	}
	

	@Override
	public String delete(Long roleId) throws RecordNotFoundException {
		Optional<UserEntity> user=userdao.findById(roleId);
		if(user.isPresent()) {
			userdao.deleteById(roleId);
			return "Successfully deleted";
		}
		else {
				throw new RecordNotFoundException("Enter the correct id");
			}
		}


	@Override
	public UserEntity update(UserEntity entity) {
		 Optional<UserEntity> user =userdao.findById(entity.getId());
         
	        if(user.isPresent())
	        {
	            UserEntity newEntity =user.get();
	            newEntity.setRoleId(entity.getRoleId());
	            newEntity.setFirstName(entity.getFirstName());
	            newEntity.setLastName(entity.getLastName());
	            newEntity.setLoginId(entity.getLoginId());
	            newEntity.setPassword(entity.getPassword());
	            newEntity.setMobileNo(entity.getMobileNo());
	            newEntity.setEmailId(entity.getEmailId());


	        UserEntity update=userdao.save(newEntity);
	        return update;
	        }
	        else
	        {
	        	UserEntity ue= userdao.save(entity);
	            return ue;
	        }
	 
	    } 

	@Override
	public UserEntity addUser(UserEntity entity) {
		Optional<UserEntity> user =userdao.findById(entity.getId());
        
        if(user.isPresent()) 
        {
            UserEntity newEntity = user.get();
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setLoginId(entity.getLoginId());
            newEntity.setPassword(entity.getPassword());
            newEntity.setMobileNo(entity.getMobileNo());
            newEntity.setEmailId(entity.getEmailId());
            newEntity.setRoleId(entity.getRoleId());
            
            newEntity = userdao.save(newEntity);
            return newEntity;
        }
        else 
        {
        	entity = userdao.save(entity);
            return entity;
        }
    } 


	@Override
	public UserEntity findByLogin(String loginId) throws RecordNotFoundException {
		 UserEntity user= userdao.findByLogin(loginId);
	       return user;
	}

	@Override
	public UserEntity registerUser(UserEntity entity) throws DuplicateRecordException {
		 Optional<UserEntity> ent=userdao.findById(entity.getId());
		  if(ent.isPresent())
		  {
			  throw new DuplicateRecordException("User Already Exists..!");
		  }
		  else
		  {
			  return userdao.save(entity);
		  }
		
		  }
		  
	@Override
	public List<UserEntity> search(String firstName) {
		List<UserEntity> search1= userdao.findAll();
		return search1;
	}

	

	@Override
	public UserEntity authenticate(String loginId, String password) throws RecordNotFoundException {
		 return userdao.findByLoginIdAndPassword(loginId, password).orElseThrow(()->new
				  RecordNotFoundException("Invalid User"));
	}
	@Override
	public List<UserEntity> listAll(String firstName) {
		 if (firstName != null) {
	            return userdao.search(firstName);
	        }
	        return userdao.findAll();
	    }
	 
	@Override
	public Page<UserEntity> search(UserEntity entity, long pageNo, int pageSize) {
		PageRequest firstPageWithTwoElements= PageRequest.of(0, 2, Sort.by("firstName"));
		  Page<UserEntity> ue=userdao.findAll(firstPageWithTwoElements);
		  return ue;
		  }

	

	
	@Override
	public String changePassword(Long id, String password) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserEntity> u=userdao.findById(id);
		if(u.isPresent())
		{
			userdao.passwordReset(id,password);
			String msg="Password Updated Successfully for User";
			return msg;
		}
		else
		{
			throw new RecordNotFoundException("No User Exists!");
		}

	}


	
}
  

