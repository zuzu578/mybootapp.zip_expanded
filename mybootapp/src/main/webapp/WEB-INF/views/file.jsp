<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="container">
 
      <div class="py-5 text-center">
           <h1> 파일 업로드 테스트 </h1>
      </div>
    
      
      <div style="margin:10% 10% 10% 10%;">
         <!--  파일첨부 -->
         <form  action="/upload" method="post"  enctype="multipart/form-data">
             <input type="file" name="file"/>
             <input class="btn btn-primary btn-sm"  type="submit" value="업로드"/>
         </form>
     </div>
 </div>