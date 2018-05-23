package br.com.antonio.qcrapi.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.antonio.qcrapi.exception.BusinessException;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<Entity, Repository extends JpaRepository<Entity, Long>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    private Repository repository;

    public Iterable<Entity> findAll() {
        return repository.findAll();
    }

    public Entity findById(Long id) {
        Optional<Entity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        return null;
    }

    public Entity save(Entity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            LOGGER.error("Falhar salvar", e.getCause());
            throw new BusinessException("Falha ao salvar o item.");
        }
    }

    public List<Entity> save(Iterable<Entity> entities) {
        try {
            return repository.saveAll(entities);
        } catch (Exception e) {
            LOGGER.error("Falhar salvar", e.getCause());
            throw new BusinessException("Falha ao salvar os items.");
        }
    }

    public Entity update(Entity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            LOGGER.error("Falhar atualizar", e.getCause());
            throw new BusinessException("Falha ao atualizar o item.");
        }
    }

    public List<Entity> update(Iterable<Entity> entities) {
        try {
            return repository.saveAll(entities);
        } catch (Exception e) {
            LOGGER.error("Falhar atualizar", e.getCause());
            throw new BusinessException("Falha ao atualizar os items.");
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            LOGGER.error("Falhar remover", e.getCause());
            throw new BusinessException("Falha ao remover o item.");
        }
    }

    public void delete(Iterable<Entity> entities) {
        try {
            repository.deleteAll(entities);
        } catch (Exception e) {
            LOGGER.error("Falhar remover", e.getCause());
            throw new BusinessException("Falha ao remover os items.");
        }
    }

    public Repository getRepository() {
        return repository;
    }

    public Long count() {
        return this.getRepository().count();
    }
}