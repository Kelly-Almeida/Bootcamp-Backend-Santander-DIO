package br.com.dio.dao;

import br.com.dio.exception.UserNotFoundException;
import br.com.dio.model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserDao {

    private long nextId = 1L;

    private final List<UserModel> models = new ArrayList<>();

    public void delete(final long id){
        var toDelete =findById(id);
        models.remove(toDelete);
    }

    public UserModel save(final UserModel model){
        model.setId(nextId++);
        models.add(model);
        return model;

    }

    public UserModel updadte(final UserModel model){
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public  UserModel findById(final long id){
        var message = String.format("Não existe o usuário com o id %d cadastrado", id);
        return models.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));

    }

    public List<UserModel> findAll(){
        return models;
    }
}
