.model small
.data
    string db 99 dup(?)
    count dw 00h

.code
    display proc
        push dx
        mov ah,02h
        int 21h
        pop dx
        ret
        display endp
    
    gotonewline proc
        push dx
        mov dl,10
        call display
        mov dl,13
        call display
        pop dx
        ret
        gotonewline endp
    
    
    main proc
        .startup
        lea si,string
        
        repeat:
            mov ah,01h
            int 21h
            
            cmp al,13
            je inputfinished
            
            mov [si],al
            inc si
            inc count
            
            jmp repeat
        inputfinished:
        mov cx,count
        lea si,string
        sub [si],20h
        call gotonewline
        again:
            mov dl,[si]
            cmp dl,' '
            jne skip
                uppercap:
                sub [si+1],20h
                call gotonewline
                inc si
                loop again
            skip:
            call display
            inc si
            loop again
            
         main endp
    end main