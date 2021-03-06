package bookshop.command;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.QnaDto;
import bookshop.controller.CommandAction;
import bookshop.dao.QnaDao;



public class _25_QnaPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		
		String qna_writer =  request.getParameter("qna_writer");
		String book_title =  request.getParameter("book_title");
		String qna_content =  request.getParameter("qna_content");
		int book_id =  Integer.parseInt(request.getParameter("book_id"));
		Byte qora =  Byte.parseByte(request.getParameter("qora"));
		byte reply = 0; //답변여부 - 미답변
		
		//qna를 추가하기 위한 정보작성
		QnaDto qna = new QnaDto();
		qna.setBook_id(book_id);
		qna.setBook_title(book_title);
		qna.setQna_content(qna_content);
        qna.setQna_writer(qna_writer);
        qna.setReply(reply);
        qna.setReg_date(new Timestamp(System.currentTimeMillis()));
		qna.setQora(qora);
		
		//qna를 테이블에 추가
		QnaDao qnaProcess = QnaDao.getInstance();
		int check = qnaProcess.insertArticle(qna);
		
		request.setAttribute("check", new Integer(check));
		
		return "/25_qnaPro.jsp";
		
	}

}
