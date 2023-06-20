package com.proyectos.gestionDeTareas.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectos.gestionDeTareas.Presentation.DTO.UserDTORequest;
import com.proyectos.gestionDeTareas.Presentation.DTO.UserDTOResponse;
import com.proyectos.gestionDeTareas.Entity.User;
import com.proyectos.gestionDeTareas.DataAcces.Repository.IUserRepository;
import com.proyectos.gestionDeTareas.Service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    ObjectMapper objectMapper;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDTOResponse getUserById(long id) {
        Optional<User> userOptional = iUserRepository.findById(id);

        try {
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                return convertUserToResponseDTO(user);
            }
        }catch (Exception e) {
            logger.error("User not found", e);
        }
        return null;
    }

    @Override
    public List<UserDTOResponse> getAllUsers() {
        try {
            List<User> userList = iUserRepository.findAll();
            return userList.stream()
                    .map(user -> objectMapper.convertValue(user, UserDTOResponse.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("an error ocurred.", e);
        }
        return null;
    }

    @Override
    public UserDTOResponse createNewUser(UserDTORequest userDTORequest) {


        try {
            if (userDTORequest == null) {
                logger.warn("IMPL | El request es null.");
                return null;
            }
            logger.info("IMPL | El request no es nulo");
            User user = objectMapper.convertValue(userDTORequest, User.class);
            logger.info("IMPL | Se convierte a la entidad");
            iUserRepository.save(user);
            logger.info("IMPL | Se guarda el nuevo usuario");
            logger.info("IMPL | Se retorna de la entidad a la repuesta.");
            return convertUserToResponseDTO(user);
        } catch (Exception e) {
            logger.error("IMPL | An error ocurred.", e);

        }
        return null;
    }

    @Override
    public UserDTOResponse updateUser(long id, UserDTORequest userDTORequest) {

        try {
            User user = iUserRepository.findById(id).orElseThrow(NoSuchElementException::new);
            objectMapper.convertValue(user, UserDTORequest.class);
            iUserRepository.save(user);
            return convertUserToResponseDTO(user);
        }catch (NoSuchElementException e) {
            logger.error("User not found.", e);
        }catch (Exception e) {
            logger.error("User update error.", e);
        }finally {
            logger.warn("Success.");
        }
        return null;
    }

    @Override
    public String deleteUser(long id) {
        Optional<User> userOptional = iUserRepository.findById(id);

        try {
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                iUserRepository.delete(user);
                return "ID: " + user.getIdUser() + " " + "Eliminated.";
            }
        } catch (Exception e) {
            logger.error("User not found.", e);
        }

        return null;
    }


    @Override
    public UserDTOResponse convertUserToResponseDTO(User user) {
        return objectMapper.convertValue(user, UserDTOResponse.class);
    }
}
