.model small
.stack 100h
.data
    msg1 db 'Enter a string: ','$'
    msg2 db 10,13,'Number of Vowels: ','$'
    string db '$', 30 dup(?) 

.code
    main proc
        .startup
        lea dx,msg1
        call displaymessage
        
        lea di,string
        lea si,string
        inc di
        again:
            mov ah,01h
            int 21h
            
            cmp al,13
            je break
            
            mov [di],al
            inc di
            jmp again
        break:
        
        mov cx,0
        repeat:
            mov bl,[di]
            cmp bl,'a'
            je vowelpresent
            cmp bl,'e'
            je vowelpresent
            cmp bl,'i'
            je vowelpresent
            cmp bl,'o'
            je vowelpresent
            cmp bl,'u'
            je vowelpresent
            cmp bl,'$'
            je last
            dec di
            jmp repeat
            
            vowelpresent:
            inc cx
            dec di
            jmp repeat
        last:
        lea dx,msg2
        call displaymessage
        
        mov dx,cx
        add dx,3030h
        mov ah,02h
        int 21h
        
        mov ah,4ch
        int 21h  
        
        main endp
    
     displaymessage proc
        push ax
        mov ah,09h
        int 21h
        pop ax
        ret
    displaymessage endp
     
    end main
        
    
    
    
    
   