.stack 1000h
.model huge

.data
    string db 'simultaneous$'
    array db 'aeiouAEIOU','$'
    msg1 db 'vowels : $'
    msg2 db 10,13,'number of vowels :','$'
    len db 13    

.code       
    
    display proc
        push ax
        push dx
        mov dl,al
        mov ah,02h
        int 21h
        pop dx
        pop ax
        ret
    display endp
        
        
    main proc 
        .startup
       
        lea dx,msg1
        mov ah,09h
        int 21h 
        
        lea si,string
        mov cx,0
        again:
            mov bl,[si]
            
            lea di,array
            inner:
                mov al,[di]
                cmp al,'$'
                je break
                
                cmp bl,al
                jne skip
                    inc cx
                    call display
                skip:
                inc di
                jmp inner
            break:
            
            cmp bl,'$'
            je last
            inc si
            jmp again
        last:
        lea dx,msg2
        mov ah,09h
        int 21h 
        
        mov ax,cx
        add ax,3030h
        call display
        
        main endp
    end main
            