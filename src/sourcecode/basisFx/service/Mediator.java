package basisFx.service;

public interface Mediator <T extends Object>  {

    public <T> void inform(T node);
}
