<#import "parts/common.ftl" as p>

<@p.page>

		<form action="/logout" method="post">
            <input type="submit" value="Sign Out"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
    <div>
        <form method="post">
            <input type="text" name="username" placeholder="Введите username" />
            <input type="text" name="email" placeholder="Email">
			<input type="text" name="password" placeholder="password">
			<input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div>Список сообщений</div>
    <form method="post" action="filter">
        <input type="username" name="username">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Найти</button>
    </form>
    <#list users as user>
    <div>
        <b>${user.id}}</b>
        <span>${user.username}</span>
        <i>${user.email}</i>
    </div>
    <#else>
    No users.
    </#list>
    
</@p.page>>