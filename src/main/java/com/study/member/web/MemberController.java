package com.study.member.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.code.service.ICommonCodeService;
import com.study.code.vo.CodeVO;
import com.study.member.service.IMemberService;
import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;


@Controller
public class MemberController {

	@Autowired
	private IMemberService memberService; 
	
	@Autowired
	private ICommonCodeService codeService; 
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// modelAttribute를 통해 공통으로 사용되는 모델객체(일반적으로 공통코드 목록)
	// 요청 메소드에 진입 전에 호출됨

	@ModelAttribute("jobList")
	public List<CodeVO> getJobList() {
		List<CodeVO> jobList = codeService.getCodeListByParent("JB00");
		return jobList;
	}

	@ModelAttribute("hobbyList")
	public List<CodeVO> getLikeList() {
		List<CodeVO> likeList = codeService.getCodeListByParent("HB00");
		return likeList;
	}

	@RequestMapping("/member/memberList")
	public void memberList2(@ModelAttribute("searchVO") MemberSearchVO searchVO
			              , ModelMap model) throws Exception {
		logger.debug("searchVO={}" ,searchVO);
		List<MemberVO> members = memberService.getMemberList(searchVO);		
		model.addAttribute("members", members);
	}
	

	@RequestMapping("/member/memberList.wow")
	@ResponseBody
	public List<MemberVO> memberList(@ModelAttribute("searchVO") MemberSearchVO searchVO
			              , ModelMap model) throws Exception {
		logger.debug("searchVO={}" ,searchVO);
		List<MemberVO> members = memberService.getMemberList(searchVO);		
		// model.addAttribute("members", members);
		return members;
	}
	
 /*
	@RequestMapping(path= "/member/memberView.wow", params = "memId")
	public String memberView(@RequestParam(value = "memId") String id, ModelMap model) throws Exception {
		logger.debug("memId={}" ,id);
		try {
			MemberVO mem = memberService.getMember(id);
			model.addAttribute("mem", mem);
			return "member/memberView";
		} catch (BizNotFoundException ex) {
			logger.error(ex.getMessage() ,ex);
			ResultMessageVO message = new ResultMessageVO();
			message.setResult(false)
			       .setTitle("회원 조회 실패")
			       .setMessage("해당 회원이 존재하지 않습니다.")
				   .setUrl("/member/memberList.wow")
				   .setUrlTitle("목록으로");
			model.addAttribute("messageVO", message);
			return "common/message";
		}

	}

	@RequestMapping(path="/member/memberEdit.wow", params = "memId")
	public String memberEdit(@RequestParam(value = "memId") String id, ModelMap model) throws Exception {
		logger.debug("memId={}" ,id);
		try {
			MemberVO mem = memberService.getMember(id);
			model.addAttribute("mem", mem);
			return "member/memberEdit";
		} catch (BizNotFoundException ex) {
			logger.error(ex.getMessage() ,ex);
			ResultMessageVO message = new ResultMessageVO();
			message.setResult(false).setTitle("멤버 조회 실패").setMessage("해당 멤버가 존재하지 않습니다.")
					.setUrl("/member/memberList.wow").setUrlTitle("목록으로");
			model.addAttribute("messageVO", message);
			return "common/message";
		}
	}

	@RequestMapping(path="/member/memberModify.wow", params = "memId" , method = RequestMethod.POST)
	public String memberModify(MemberVO member, ModelMap model, HttpServletRequest req) throws Exception {
		logger.debug("member={}" ,member);
		ResultMessageVO message = new ResultMessageVO();
		try {
			memberService.modifyMember(member);
			return "redirect:/member/memberView.wow?memId=" + member.getMemId();

		} catch (BizNotFoundException ex1) {
			logger.error(ex1.getMessage() ,ex1);			
			message.setResult(false)
			       .setTitle("회원 수정 실패")
			       .setMessage("해당 회원이 존재하지 않습니다.")
				   .setUrl("/member/memberList.wow")
				   .setUrlTitle("목록으로");
		} catch (BizNotEffectedException ex2) {
			logger.error(ex2.getMessage() ,ex2);
			message.setResult(false)
			       .setTitle("회원 수정 실패")
			       .setMessage("회원정보가 변경되지 않았습니다.")
				   .setUrl("/member/memberList.wow")
				   .setUrlTitle("목록으로");
		}
		model.addAttribute("messageVO", message);
		return "common/message";
	}

	@RequestMapping("/member/memberForm.wow")
	public void memberForm( @ModelAttribute("mem") MemberVO member ) throws Exception {

	}

	@RequestMapping(path="/member/memberRegist.wow", method = {RequestMethod.POST})
	public ModelAndView memberRegist(MemberVO member, HttpServletRequest req) {
		logger.debug("member={}" ,member);
		ModelAndView mav = new ModelAndView();
		ResultMessageVO message = new ResultMessageVO();
		// 글 입력 성공시 메시지를 보여줄 필요없이 바로 목록으로 가고자한다.
		try {
			memberService.registMember(member);
			mav.setViewName("redirect:/member/memberList.wow");
		} catch (BizDuplicateKeyException e) {
			logger.error(e.getMessage() ,e);
			message.setResult(false).setTitle("아이디 중복 오류")
				.setMessage("해당 아이디가 이미 사용중입니다.")
				.setUrl("/member/memberList.wow")
				.setUrlTitle("목록으로");
				// 속성에 messageVO로 저장
				mav.addObject("messageVO", message);
				mav.setViewName("common/message");
		}

		return mav;

	}
	
	@RequestMapping(path= "/member/memberCheckedDelete.wow", params = "memId")
	public String memberCheckedDelete(
			    @RequestParam(name = "memId") String[] memIds
			 ,  ModelMap model) {		
		memberService.checkedMemberDelete(memIds);
		ResultMessageVO message = new ResultMessageVO();
		message.setResult(true)
		       .setTitle("회원탈퇴")
		       .setMessage("회원탈퇴를 하였습니다.")
		       .setUrl("/member/memberList.wow")
		       .setUrlTitle("목록으로");
		model.addAttribute("messageVO", message);
		return "common/message";
	}
	*/
}
