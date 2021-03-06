.model small
.stack 100h
.data
    string db 'You know nothing Jon Snow$'

.code
    display proc
        push ax
        mov ah,02h
        int 21h        
        pop ax 
        ret
    display endp
    
    main proc
        .startup
        lea si, string
        
        repeat:
            mov ah,[si]
            cmp ah,60h
            ja small
            
            cmp ah,' '
            je space
            
            cmp ah,'$'
            je break
            
            cmp ah,5ah
            jbe capital
            

            
            space:
            mov dl,[si]
            call display
            inc si
            jmp repeat
            
            small:
            sub [si],20h
            mov dl,[si]
            inc si
            call display
            jmp repeat
             
            capital:
            add [si],20h            
            mov dl,[si]
            inc si
            call display
            jmp repeat
                       
       break:
       
       main endp
    end main
       
            