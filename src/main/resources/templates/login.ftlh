<#import "parts/common.ftl" as p>

<@p.page>
Привет пожалуйста зарегистрируйтесь


<div>
        <form action="/login" method="post">
            <input type="text" name="username" placeholder="Введите username" />
            <input type="text" name="password" placeholder="password">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div><input type="submit" value="Sign In"/></div>
        </form>
</div>
 <a href="/registration">Add new user</a>
</@p.page>