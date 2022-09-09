package one.digitalinnovation.labpadroesprojetospring.service;

import one.digitalinnovation.labpadroesprojetospring.domain.entity.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

  //@GetMapping("/{cep}/json/") - tb pode ser assim
  @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
  Endereco consultaCep(@PathVariable("cep") String cep);
}
