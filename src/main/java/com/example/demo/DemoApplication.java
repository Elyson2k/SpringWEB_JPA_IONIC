package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Categoria;
import com.example.demo.entities.Cidade;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Endereco;
import com.example.demo.entities.Estado;
import com.example.demo.entities.ItemPedido;
import com.example.demo.entities.PagamentoBoleto;
import com.example.demo.entities.PagamentoCartao;
import com.example.demo.entities.Pedido;
import com.example.demo.entities.Produto;
import com.example.demo.entities.enums.EstadoPagamento;
import com.example.demo.entities.enums.TipoCliente;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.CidadeRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.repository.EstadoRepository;
import com.example.demo.repository.ItemPedidoRepository;
import com.example.demo.repository.PagamentoRepository;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.repository.ProdutoRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica"); 
		Categoria cat2 = new Categoria(null, "Escritorio"); 
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impresora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
				
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().add(cat1);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().add(p2);
			
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");
		
		Cidade c1 = new Cidade(null, "Campinas", est1);
		Cidade c2 = new Cidade(null, "Uberlandia", est2);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		
		est1.getCidades().add(c1);
		est2.getCidades().addAll(Arrays.asList(c1,c2));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Gomes", "maria@gmail.com", "000.000.000-01", TipoCliente.PESSOA_FISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("9999-8888", "000-2222"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardin", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "523834", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017") ,cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("30/09/2017") ,cli1, e2);
		
		cli1.getPedidos().add(ped1);
		cli1.getPedidos().add(ped2);
		
		PagamentoCartao pagto1 = new PagamentoCartao(null, EstadoPagamento.PAGO, ped1, 6);
		PagamentoBoleto pagto2 = new PagamentoBoleto(null, EstadoPagamento.AGUARDANDO, sdf.parse("20/10/2017"), null ,ped2);
		
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,00.00,1,2000.00);
		ItemPedido ip2 = new ItemPedido(ped1,p2,00.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(ped2,p3,100.00,1,800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));

		
	}

}
