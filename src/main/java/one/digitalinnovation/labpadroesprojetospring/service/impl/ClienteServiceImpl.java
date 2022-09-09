package one.digitalinnovation.labpadroesprojetospring.service.impl;

import one.digitalinnovation.labpadroesprojetospring.domain.entity.Cliente;
import one.digitalinnovation.labpadroesprojetospring.domain.entity.Endereco;
import one.digitalinnovation.labpadroesprojetospring.domain.repository.ClienteRepository;
import one.digitalinnovation.labpadroesprojetospring.domain.repository.EnderecoRepository;
import one.digitalinnovation.labpadroesprojetospring.service.ClienteService;
import one.digitalinnovation.labpadroesprojetospring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;
  @Autowired
  private EnderecoRepository enderecoRepository;
  @Autowired
  private ViaCepService viaCepService;

  @Override
  public Iterable<Cliente> buscarTodos() {
    return clienteRepository.findAll();
  }

  @Override
  public Cliente buscarPorId(Long id) {
    Cliente cliente = clienteRepository.findById(id).get();
    return cliente;
  }

  @Override
  public void inserir(Cliente cliente) {
      salvarClienteComCep(cliente);
  }

  @Override
  public void atualizar(Long id, Cliente cliente) {
    Optional<Cliente> clienteBd = clienteRepository.findById(id);
    if (clienteBd.isPresent()) {
        salvarClienteComCep(cliente);
    }
  }

  @Override
  public void deletar(Long id) {
    clienteRepository.deleteById(id);
  }

  private void salvarClienteComCep(Cliente cliente) {
    String cep = cliente.getEndereco().getCep();
    Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
      Endereco novoEndereco = viaCepService.consultaCep(cep);
      enderecoRepository.save(novoEndereco);
      return novoEndereco;
    });
    cliente.setEndereco(endereco);
    clienteRepository.save(cliente);
  }
}
