package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import br.senai.sp.jandira.Repository.AlunoRepository;
import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;

import javax.management.ListenerNotFoundException;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField txtmatricula;
	private JTextField txtNome;

	private int posicao;
	
	public FrameCadastroAlunos() {
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblmatricula = new JLabel("Matr\u00EDcula");
		lblmatricula.setToolTipText("");
		lblmatricula.setBounds(10, 22, 61, 14);
		contentPane.add(lblmatricula);

		txtmatricula = new JTextField();
		txtmatricula.setBounds(81, 19, 86, 20);
		contentPane.add(txtmatricula);
		txtmatricula.setColumns(10);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setToolTipText("");
		lblNome.setBounds(10, 50, 46, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(81, 47, 116, 20);
		contentPane.add(txtNome);

		JLabel lblperiodo = new JLabel("Per\u00EDodo :");
		lblperiodo.setBounds(10, 87, 46, 14);
		contentPane.add(lblperiodo);

		DefaultComboBoxModel<String> ModelPeriodo = new DefaultComboBoxModel<String>();
		for (Periodo periodo : Periodo.values()) {

			ModelPeriodo.addElement(periodo.getDescricao());

		}

		JComboBox comboPeriodo = new JComboBox();

		comboPeriodo.setModel(ModelPeriodo);
		comboPeriodo.setBounds(66, 83, 86, 22);
		contentPane.add(comboPeriodo);

		JButton btnsalvar = new JButton("Salvar aluno");
		btnsalvar.setBounds(29, 141, 164, 23);
		contentPane.add(btnsalvar);

		JLabel lbllista = new JLabel("Lista de Alunos :");
		lbllista.setBounds(232, 22, 86, 14);
		contentPane.add(lbllista);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(232, 50, 144, 200);
		contentPane.add(scrollPane);

		JList<String> listAlunos = new JList<String>();

		listAlunos.setBounds(232, 49, 144, 201);
		contentPane.add(listAlunos);

		DefaultListModel<String> modelAlunos = new DefaultListModel<String>();

		listAlunos.setModel(modelAlunos);

		AlunoRepository turma = new AlunoRepository(3);


		
		listAlunos.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				Aluno aluno = turma.listarAluno(listAlunos.getSelectedIndex());
				txtmatricula.setText(aluno.getMatricula());
				txtNome.setText(aluno.getNome());
				
				comboPeriodo.setSelectedIndex(aluno.getPeriodo().ordinal());
			}
		});
		
		btnsalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Aluno aluno = new Aluno();
				aluno.setNome(txtNome.getText());
				aluno.setMatricula(txtmatricula.getText());
				
				aluno.setPeriodo(determinarPeriodo(comboPeriodo.getSelectedIndex()));
				
				turma.gravar(aluno, posicao);

				posicao++; 

				if (posicao == turma.getTamanho()) {
					btnsalvar.setEnabled(false);
					JOptionPane.showConfirmDialog(null," A turma está cheia","cheia !", JOptionPane.WARNING_MESSAGE);
				}
				
				modelAlunos.addElement(aluno.getNome());

			}
		});
	}
		
	

		private Periodo determinarPeriodo(int periodoSelecionado){
			
		
			
			if (periodoSelecionado == 0) {
				return Periodo.MANHA;
			}
			else if (periodoSelecionado == 1) {
				return Periodo.TARDE;
			}
			else if (periodoSelecionado == 2) {
				return Periodo.NOITE;
			}
			else if (periodoSelecionado == 3) {
				return Periodo.SABADO;
			}
			else {
				return Periodo.ONLINE;
			}
			
			
		}                                                                                                 
	 
		
		
		
	
}
