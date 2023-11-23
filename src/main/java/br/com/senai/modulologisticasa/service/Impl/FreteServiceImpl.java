package br.com.senai.modulologisticasa.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import br.com.senai.modulologisticasa.entity.Frete;
import br.com.senai.modulologisticasa.repository.FretesRepository;
import br.com.senai.modulologisticasa.service.FreteService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
public class FreteServiceImpl implements FreteService {

	@Autowired
	private FretesRepository repository;

	@Override
	public Frete salvar(Frete frete) {
		Frete freteSalvo = repository.save(frete);
		return repository.buscarPorId(freteSalvo.getId());
	}

	@Override
	public void atualizarStatusPor(Integer id, Integer status) {
		
		Frete freteEncontrado = repository.buscarPorId(id);
		Preconditions.checkNotNull(freteEncontrado, "Não existe Frete vinculado ao ID informado");
		Preconditions.checkArgument(freteEncontrado.getStatus() != status,
				"O status já esta salvo para o Frete");
		this.repository.atualizarPor(id, status);
		
	}

	@Override
	public Frete buscarPor(Integer id) {
		Frete freteEncontrado = repository.buscarPorId(id);
		Preconditions.checkNotNull(freteEncontrado, "Não foi encontrado frete para o id informado");
		return freteEncontrado;
	}
	
	@Override
	public List<Frete> listarPor(Integer id,Integer mes, Integer status) {
		return repository.listarPor(id, mes, status);
	}
	
}
