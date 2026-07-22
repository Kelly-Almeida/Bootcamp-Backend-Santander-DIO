package br.com.dio.dao;

import br.com.dio.exception.EmptyStorageException;
import br.com.dio.exception.UserNotFoundException;
import br.com.dio.model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserDao {

    private long nextId = 1L;

    private final List<UserModel> models = new ArrayList<>();

    public void delete(final long id) throws UserNotFoundException{
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    public UserModel save(final UserModel model){
        model.setId(nextId++);
        models.add(model);
        return model;

    }

    public UserModel update(final UserModel model){
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public  UserModel findById(final long id){
        verifyStorage();
        var message = String.format("Não existe o usuário com o id %d cadastrado", id);
        return models.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));

    }

    public List<UserModel> findAll(){
        List<UserModel> result;

        try {
            verifyStorage();
            result = models;
        }catch (EmptyStorageException ex){
            ex.printStackTrace();
            result = new ArrayList<>();
        }

        return models;

    }

    private void verifyStorage(){
        if (models.isEmpty()) throw new EmptyStorageException("O armazenamento está vazio");
    }
}
